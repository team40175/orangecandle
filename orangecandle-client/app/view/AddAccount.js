Ext.define('OrangeCandle.view.AddAccount', {
	extend : 'Ext.form.Panel',
	alias : "widget.addaccount",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		// fullscreen : true,
		layout : 'vbox',
		title : 'Account Adding:',
		scrollable : false,
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'username',
				name : 'name',
				required : true
			} ]
		}, {
			xtype : 'list',
			flex : 1,
			mode : 'multi',
			itemTpl : '{text}',
			data : [ {
				text : 'Student'
			}, {
				text : 'Teacher'
			}, {
				text : 'Administrator'
			} ]
		} ]

	}
})