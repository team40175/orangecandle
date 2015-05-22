Ext.define('OrangeCandle.view.AddSchool', {
	extend : 'Ext.form.Panel',
	alias : "widget.addschool",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		scrollable : 'false',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'hiddenfield',
				name : 'id'
			}, {
				xtype : 'textfield',
				placeHolder : 'Name of the School',
				name : 'name',
				required : true
			} ]
		}, {
			xtype : 'button',
			text : 'Save',
			target : "school/add"
		} ]
	}
})
