Ext.define('OrangeCandle.view.AddClassroom', {
	extend : 'Ext.form.Panel',
	alias : "widget.addclassroom",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		scrollable:'false',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'textfield',
				placeHolder : 'Name of the Classroom',
				name : 'name',
			}, {
				xtype : 'textfield',
				placeHolder : 'Building of the Classroom',
				name : 'building',
			}, ]
		}, {
			xtype : 'button',
			text : 'submit',
			target : "room/add"
		} ]
	}
})