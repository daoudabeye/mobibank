package org.wallet.ui;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.wallet.LoginView;
import org.wallet.event.DashboardEvent.BrowserResizeEvent;
import org.wallet.event.DashboardEvent.CloseOpenWindowsEvent;
import org.wallet.event.DashboardEvent.UserLoggedOutEvent;
import org.wallet.event.DashboardEvent.UserLoginRequestedEvent;
import org.wallet.event.DashboardEventBus;
import org.wallet.models.User;
import org.wallet.services.UserService;
import org.wallet.ui.view.MainView;

import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.server.WebBrowser;
import com.vaadin.shared.Position;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

@Theme("dashboard")
@Title("Mobibank")
@SpringUI
@SuppressWarnings("serial")
public class DashboardUI extends UI {

	private final DashboardEventBus dashboardEventbus = new DashboardEventBus();

	@Autowired
	UserService userService;

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		setLocale(Locale.FRENCH);

		DashboardEventBus.register(this);
		Responsive.makeResponsive(this);
		addStyleName(ValoTheme.UI_WITH_MENU);

		updateContent();

		// Some views need to be aware of browser resize events so a
		// BrowserResizeEvent gets fired to the event bus on every occasion.
		Page.getCurrent().addBrowserWindowResizeListener(
				new BrowserWindowResizeListener() {
					@Override
					public void browserWindowResized(
							final BrowserWindowResizeEvent event) {
						DashboardEventBus.post(new BrowserResizeEvent());
					}
				});

	}
	public static DashboardEventBus getDashboardEventbus() {
		return ((DashboardUI) getCurrent()).dashboardEventbus;
	}

	/**
	 * Updates the correct content for this UI based on the current user status.
	 * If the user is logged in with appropriate privileges, main view is shown.
	 * Otherwise login view is shown.
	 */
	private void updateContent() {
		User user = (User) VaadinSession.getCurrent().getAttribute(
				User.class.getName());
		if (user != null) {
			// Authenticated user
			setContent(new MainView());
			removeStyleName("loginview");
			getNavigator().navigateTo(getNavigator().getState());
		} else {
			setContent(new LoginView());
			addStyleName("loginview");
		}
	}

	@Subscribe
	public void userLoginRequested(final UserLoginRequestedEvent event) {
		User user = userService.findByUsername(event.getUserName());
		String message = "";

		if(user == null){
			message = "Identifiant utilisateur incorrect";
		}else{
			if(userService.checkPassword(event.getPassword(), user.getPassword())){
				VaadinSession.getCurrent().setAttribute(User.class.getName(), user);
				WebBrowser webBrowser = Page.getCurrent().getWebBrowser();
				userService.updateLoginDate(user.getId(), new Date(), webBrowser.getAddress());
				updateContent();
			}else
				message = "Mot de passe incorrect";
		}

		Notification notification = new Notification(
				"Erreur", Type.ERROR_MESSAGE);
		notification
		.setDescription("<span>"+message+"</span>");
		notification.setHtmlContentAllowed(true);
		notification.setStyleName("bar warning small");
		notification.setPosition(Position.TOP_CENTER);
		notification.setDelayMsec(6000);
		if(!message.isEmpty())
			notification.show(Page.getCurrent());
	}

	@Subscribe
	public void userLoggedOut(final UserLoggedOutEvent event) {
		// When the user logs out, current VaadinSession gets closed and the
		// page gets reloaded on the login screen. Do notice the this doesn't
		// invalidate the current HttpSession.
		VaadinSession.getCurrent().close();
		Page.getCurrent().reload();
	}

	@Subscribe
	public void closeOpenWindows(final CloseOpenWindowsEvent event) {
		for (Window window : getWindows()) {
			window.close();
		}
	}

}
