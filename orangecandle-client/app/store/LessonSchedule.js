Ext.define('OrangeCandle.store.LessonSchedule', {
	extend : 'Ext.data.TreeStore',
	config : {
		model : 'OrangeCandle.model.LessonSchedule',
		defaultRootProperty : 'items',
		root : {
			items : [ {
				name : 'Monday',
				items : [ {
					name : 'Ceng311',
					leaf : true
				} ]
			}, {
				name : 'Tuesday',
				leaf : true
			}, {
				name : 'Wednesday',
				leaf : true
			}, {
				name : 'Thursday',
				leaf : true
			}, {
				name : 'Friday',
				leaf : true
			} ],
		},
		autoLoad:true
	}
});