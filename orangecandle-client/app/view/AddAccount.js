Ext.define('OrangeCandle.view.AddAccount', {
	extend : 'Ext.form.Panel',
	alias : "widget.addaccount",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		title : 'Insert Account',
		scrollable : false,
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'hiddenfield',
				name : 'id'
			}, {
				xtype : 'textfield',
				itemId : 'userName',
				placeHolder : 'User Name',
				name : 'username',
				required : true
			} ]
		}, {
			xtype : 'list',
			name : 'groups',
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