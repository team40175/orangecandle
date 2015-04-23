Ext.define('OrangeCandle.view.AddSchool', {
	extend : 'Ext.form.Panel',
	alias : "widget.addschool",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Insert a new School',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'Name of the School',
				name : 'code',
				required : true
			} ]
		}, 
		{
			xtype : 'button',
			text : 'submit'
		} ]
	}
})
