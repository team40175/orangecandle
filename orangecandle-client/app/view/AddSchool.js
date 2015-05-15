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
				itemId : 'schoolName',
				name : 'name',
				required : true
			} ]
		}, {
			xtype : 'button',
			text : 'submit',
			target : "school/add"
		} ]
	}
})
