Ext.define('OrangeCandle.view.AddAccount', {
	extend : 'Ext.form.Panel',
	alias : "widget.addaccount",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		itemId : 'accountPanel',
		title : 'Insert Account',
		scrollable : false,
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				itemId : 'userName',
				placeHolder : 'UserName',
				name : 'userName',
				required : true
			} ]
		}, {
			xtype : 'list',
			flex : 1,
			itemId : 'groupList',
			mode : 'multi',
			itemTpl : '{name}',
			store : 'Group'
		}, {
			xtype : 'button',
			text : 'submit',
			target : "user/add"
		} ]
	}

})