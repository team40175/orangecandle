Ext.define('OrangeCandle.model.Lecture', {
	extend : 'Ext.data.Model',
	config : {
		fields : [ {
			name : 'name',
			type : 'string'
		}, {
			name : 'schoolname',
			mapping : 'department.faculty.school.name'
		} ]
	}
});