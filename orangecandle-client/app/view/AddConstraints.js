Ext.define('OrangeCandle.view.AddConstraints', {
	extend : 'Ext.form.Panel',
	alias : "widget.addconstraints",
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		scrollable : 'false',
		layout : 'vbox',
		items : [ {
			xtype : 'fieldset',
			items : [ {
				xtype : 'hiddenfield',
				name : 'id'
			}, {
				xtype : 'hiddenfield',
				name : 'username',
				getValue : function() {
					return OrangeCandle.util.Auth.username;
				}
			}, {
				xtype : 'textfield',
				placeHolder : 'Name of the constraint',
				name : 'name',
			}, {
				xtype : 'textfield',
				placeHolder : 'Evaluation text',
				name : 'text',
			}, ]
		}, {
			xtype : 'list',
			name : 'users',
			flex : 1,
			itemTpl : '{username}',
			store : 'xUser'
		}, {
			xtype : 'list',
			name : 'lectures',
			flex : 1,
			itemTpl : '{name}',
			store : 'Lecture'
		}, {
			xtype : 'list',
			name : 'classrooms',
			flex : 1,
			itemTpl : '{name}',
			store : 'Room'
		}, {
			xtype : 'button',
			text : 'Save',
			target : "constraint/add"
		} ]
	}
})