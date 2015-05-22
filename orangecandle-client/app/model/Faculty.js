Ext.define('OrangeCandle.model.Faculty', {
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