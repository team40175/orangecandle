Ext.define('OrangeCandle.view.AddGroups', {
	extend : 'Ext.form.Panel',
	alias : "widget.addgroups",
	requires : [ 'Ext.form.Panel', 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		title : 'Group Adding:',
		items : [ {
			xtype : 'fieldset',
			flex : 1,
			items : [ {
				xtype : 'textfield',
				placeHolder : 'GroupName',
				itemId : 'groupNameTextField',
				name : 'groupNameTextField',
				required : true,

			} ]
		}, {
			xtype : 'list',
			flex : 2,
			mode : 'multi',
			itemId:'grouplist',
			itemTpl : '{text}',
			store:'Role',

		}, {
			xtype : 'button',
			text : 'Submit',
			itemId : 'groupSubmitButton'
				
		} ]
//		submit(this,)
	}
})