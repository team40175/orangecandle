Ext.define('OrangeCandle.form.Building', {
	extend : 'Ext.form.Panel',
	alias : "widget.buildingform",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		scrollable : false,
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'hiddenfield',
				name : 'id'
			}, {
				xtype : 'textfield',
				placeHolder : 'Name of the Building',
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
			text : 'submit',
			target : "building/add"
		} ]
	}

})