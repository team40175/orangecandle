Ext.define('OrangeCandle.model.Buttons', {
	extend : 'Ext.data.Model',
	config : {
		fields : [ {
			name : 'Administrator',
			type : 'auto'
		}, {
			name : 'Advisor',
			type : 'auto,'
		}, {
			name : 'Teacher',
			type : 'auto'
		}, {
			name : 'Student',
			type : 'auto'
		}, {
			name : 'All',
			type : 'auto'
		} ]
	}
});