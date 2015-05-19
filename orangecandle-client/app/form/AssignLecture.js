Ext.define('OrangeCandle.form.AssignLecture', {
	extend : 'Ext.form.Panel',
	xtype : 'assignlecture',
	requires : [ 'Ext.form.FieldSet' ],
	config : {
		layout : 'vbox',
		title : 'Insert Account',
		scrollable : false,
		items : [ {
			xtype : 'list',
			name : 'teachers',
			flex : 1,
			itemTpl : '{username}',
			store : 'Teacher'
		}, {
			xtype : 'list',
			name : 'lectures',
			flex : 1,
			itemTpl : '{name}',
			store : 'Lecture'
		}, {
			xtype : 'button',
			text : 'submit',
			target : "user/assignLectures"
		} ]
	}

})