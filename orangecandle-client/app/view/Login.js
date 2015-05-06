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
				name : 'username'
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Password',
				name : 'password'
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
		this.fireEvent('signInCommand', this,
				this.down('textfield').getValue(), this.down('passwordfield')
						.getValue());
	}
});
