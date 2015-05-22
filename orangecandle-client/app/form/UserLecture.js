Ext.define('OrangeCandle.form.UserLecture', {
	extend : 'Ext.form.Panel',
	xtype : 'userlecture',
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		title : 'Insert Account',
		scrollable : false,
		items : [ {
			xtype : 'list',
			name : 'lectures',
			flex : 1,
			mode : 'multi',
			itemTpl : '{name}',
			store : 'Lecture'
		}, {
			xtype : 'fieldset',
			items : [ {
				xtype : 'hiddenfield',
				name : 'username',
				getValue : function() {
					return OrangeCandle.util.Auth.getUsername();
				}
			} ]
		}, {
			xtype : 'button',
			text : 'Save',
			target : "user/pickLectures"
		} ]
	}

})