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
				xtype : 'hiddenfield',
				name : 'username',
				getValue : function() {
					return OrangeCandle.util.Auth.username;
				}
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Old Password',
				name : 'oldPw'
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Enter New Password',
				name : 'newPw1'
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Re-enter New Password',
				name : 'newPw2'
			} ]
		}, {
			xtype : 'button',
			text : 'Change Password',
			padding : '10px',
			docked : 'bottom',
			target : "user/changePassword",
			itemId : "passwordSubmit"
		} ]
	}

});
