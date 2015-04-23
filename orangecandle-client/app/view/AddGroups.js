Ext.define('OrangeCandle.view.AddGroups', {
	extend : 'Ext.form.Panel',
	alias : "widget.addgroups",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Group Adding:',
		items : [ {
			xtype : 'fieldset',
			title : 'Group Information',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'GroupName',
				itemId : 'groupNameTextField',
				name : 'groupNameTextField',
				required : true
			}, {
				xtype : 'list',
				fullscreen : true,
				itemTpl : '{title}',
				data : [ {
					title : 'Item 1'
				}, {
					title : 'Item 2'
				}, {
					title : 'Item 3'
				}, {
					title : 'Item 4'
				} ]
			} ]
		} ]
	}
})