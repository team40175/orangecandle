Ext.define('OrangeCandle.view.AddAccount', {
	extend : 'Ext.form.Panel',
	alias : "widget.addaccount",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		fullscreen : true,
		layout : 'vbox',
		title : 'Account Adding:',
		items : [ {
			xtype : 'fieldset',
			flex : 1,
			items : [ {
				xtype : 'textfield',
				placeHolder : 'accountName',
				itemId : 'accountNameTextField',
				name : 'accountNameTextField',
				required : true
			} ]
		}, {
			xtype : 'list',
			flex : 2,
			mode : 'multi',
			itemTpl : '{text}',
			data : [ {
				text : 'Student'
			}, {
				text : 'Teacher'
			}, {
				text : 'Administrator'
			} ]
		} ,
		]
			

	}
})