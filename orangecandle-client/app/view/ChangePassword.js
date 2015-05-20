Ext.define('OrangeCandle.view.ChangePassword', {
	extend : 'Ext.form.Panel',
	xtype : "changepassword",
	requires : [ 'Ext.form.FieldSet', 'Ext.form.Password', 'Ext.MessageBox' ],
	config : {
		scrollable : 'false',
		layout : 'vbox',
		title : 'Change Password',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'Username',
				name : 'username'
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Old Password',
				name : 'old'
			}, {
				xtype : 'passwordfield',
				placeHolder : 'New Password',
				name : 'new'
			} ]
		}, {
			xtype : 'button',
			text : 'Change Password',
			padding : '10px',
			docked : 'bottom',
			target : "user/changePassword"
		} ]
	},
});
