Ext.define('OrangeCandle.view.ChangePassword', {
	extend : 'Ext.form.Panel',
	xtype : "changePassword",
	requires : [ 'Ext.form.FieldSet', 'Ext.form.Password', 'Ext.MessageBox' ],
	config : {
		title : 'Login',
		items : [ {
			xtype : 'fieldset',
			title : 'Change Password',
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
			target : "user/changePassword"
		}]
	},
});
