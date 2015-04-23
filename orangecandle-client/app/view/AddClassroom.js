Ext.define('OrangeCandle.view.AddClassroom', {
	extend : 'Ext.form.Panel',
	alias : "widget.addclassroom",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		title : 'Classroom Information:',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'Name of the Classroom',
				name : 'code',
				required : true
			}, {
				xtype : 'textfield',
				placeHolder : 'Building of the Classroom',
				name : 'name',
				required : true
			},{
				xtype : 'textfield',
				placeHolder : 'Department of the Classroom',
				name : 'name',
				required : true
			} ]
		}, 
		{
			xtype : 'button',
			text : 'submit'
		} ]
	}
})