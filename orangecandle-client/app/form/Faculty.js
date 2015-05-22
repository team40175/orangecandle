Ext.define('OrangeCandle.form.Faculty', {
	extend : 'Ext.form.Panel',
	alias : "widget.facultyform",
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
				placeHolder : 'Name of the Faculty',
				name : 'name',
				required : true
			} ]
		}, {
			xtype : 'list',
			name : 'schools',
			flex : 1,
			itemTpl : '{name}',
			store : 'School'
		}, {
			xtype : 'button',
			text : 'Save',
			target : "faculty/add"
		} ]
	}

})