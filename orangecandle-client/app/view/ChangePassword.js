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
				placeHolder : 'Old password',
				name : 'oldPw'
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Enter new password',
				name : 'newPw1'
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Re-enter new password',
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
