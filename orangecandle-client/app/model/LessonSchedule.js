Ext.define('OrangeCandle.model.LessonSchedule', {
	extend : 'Ext.data.Model',
	config : {
		fields : [ {
			name : 'Monday',
			type : 'auto'
		}, {
			name : 'Tuesday',
			type : 'auto'
		}, {
			name : 'Wednesday',
			type : 'auto'
		}, {
			name : 'Thursday',
			type : 'auto'
		},{
			name : 'Friday',
			type : 'auto'
		}  ]
	}
});