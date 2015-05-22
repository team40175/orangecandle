Ext.define('OrangeCandle.view.ViewLessons', {
	extend : 'Ext.form.Panel',
	alias : 'widget.viewlessons',
	requires : [ 'Ext.form.Panel', 'Ext.form.FieldSet' ],
	config : {
		layout : 'card',
		scrollable : 'false',
		items : [ {
			xtype : 'grid',
			name : 'lessonlist',
			itemId : 'grouplist',
			itemTpl : '{name}',
			store : 'Role',
			columns : [ {
				text : 'Monday',
				dataIndex : 'Monday',
				width : 150
			}, {
				text : 'Tuesday',
				dataIndex : 'Tuesday',
				width : 150
			}, {
				text : 'Wednesday',
				dataIndex : 'Wednesday',
				width : 150
			}, {
				text : 'Thursday',
				dataIndex : 'Thursday',
				width : 150
			},{
				text : 'Friday',
				dataIndex : 'Friday',
				width : 150
			}  ]

		} ]
	}
})