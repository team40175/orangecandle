Ext.define('OrangeCandle.store.LessonSchedule', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.LessonSchedule',
		proxy : {
			type : 'ajax',
			url : 'app/data/user/getLessons',
			reader : {
				type : "json",
			}
		},
		autoLoad : true
	}
});