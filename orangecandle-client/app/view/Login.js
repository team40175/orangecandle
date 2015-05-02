Ext.define('OrangeCandle.view.Login', {
	extend : 'Ext.form.Panel',
	xtype : "loginview",
	requires : [ 'Ext.form.FieldSet', 'Ext.form.Password', 'Ext.MessageBox' ],
	config : {
		title : 'Login',
		items : [ {
			xtype : 'fieldset',
			title : 'Login',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'Username',
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Password',
			} ]
		}, {
			xtype : 'button',
			itemId : 'logInButton',
			ui : 'action',
			padding : '10px',
			text : 'Log In'
		} ],
		listeners : [ {
			delegate : '#logInButton',
			event : 'tap',
			fn : 'onLogInButtonTap'
		} ],
	},
	onLogInButtonTap : function() {
		var usernameField = this.down('textfield');
		var passwordField = this.down('passwordfield');
		var username = usernameField.getValue();
		password = passwordField.getValue();
		this.fireEvent('signInCommand', this, username, password);
	},
	showSignInFailedMessage : function(message) {
		Ext.Msg.alert("", "Sign in failed", Ext.emptyFn);
	}

});
