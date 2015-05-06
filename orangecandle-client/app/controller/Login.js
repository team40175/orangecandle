Ext.define('OrangeCandle.controller.Login', {
	extend : 'Ext.app.Controller',
	config : {
		refs : {
			loginView : 'loginview',
			mainMenuView : 'mainmenuview'
		},
		control : {
			loginView : {
				signInCommand : 'onSignInCommand'
			}
		}
	},
	onSignInCommand : function(view, username, password) {
		var loginView = this.getLoginView();
		if (username.length === 0 || password.length === 0) {
			loginView.showSignInFailedMessage('You need to enter something');
			return;
		}
		loginView.setMasked({
			xtype : 'loadmask',
			message : 'Signing In...'
		});
		OrangeCandle.util.Auth.set(username, password);
		view.submit({
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			url : OrangeCandle.util.Scalability.getApplicationServer("login"),
			method : 'POST',
			success : function(form, result) {
				loginView.setMasked(false);
				Ext.Viewport.setActiveItem(this.getMainMenuView());
			},
			failure : function(form, result) {
				this.getLoginView().setMasked(false);
				Ext.Msg.alert("", "Sign in failed", Ext.emptyFn);
			}
		});
	}
});
