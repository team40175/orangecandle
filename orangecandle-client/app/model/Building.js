Ext.define('OrangeCandle.model.Building', {
	extend : 'Ext.data.Model',
	config : {
		fields : [ {
			name : 'name',
			type : 'string'
		}, {
			name : 'schoolname',
			mapping : 'school.name'
		} ]
	}
});