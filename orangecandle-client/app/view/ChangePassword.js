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
				xtype : 'passwordfield',
				placeHolder : 'Old Password',
				name : 'old'
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Enter New Password',
				name : 'new'
			}, {
				xtype : 'passwordfield',
				placeHolder : 'Re-enter New Password'
			} ]
		}, {
			xtype : 'button',
			text : 'Change Password',
			padding : '10px',
			docked : 'bottom',
			target : "user/changePassword",
			itemId : "passwordSubmit"
		} ],
		listeners : {
			beforesubmit : function() {
				var pass1 = Ext.ComponentQuery
						.query('changepassword passwordfield[name="new"]')[0]
						.getValue();
				var pass2 = Ext.ComponentQuery
						.query('changepassword passwordfield[name=null]')[0]
						.getValue();
				if (pass1 !== pass2) {
					Ext.Msg.alert('', 'Passwords do not match.', Ext.emptyFn);
				}
				return pass1 === pass2;
			}
		}
	}

});
