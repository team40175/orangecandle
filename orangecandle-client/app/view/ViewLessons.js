Ext.define('OrangeCandle.view.ViewLessons', {
	extend : 'Ext.form.Panel',
	alias : 'widget.viewlessons',
	requires : [ 'Ext.form.Panel', 'Ext.form.FieldSet',
			'Ext.dataview.NestedList', 'Ext.data.TreeStore' ],
	config : {
		scrollable : 'false',
		layout : 'fit',
		items : [ {
			title : 'Weekly Schedule',
			itemId : 'schedule',
			xtype : 'nestedlist',
			store : 'LessonSchedule',
			displayField:'name'
		} ]
	}
})