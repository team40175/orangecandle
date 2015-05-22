Ext.define('OrangeCandle.model.Department', {
	extend : 'Ext.data.Model',
	config : {
		fields : [ {
			name : 'name',
			type : 'string'
		}, {
			name : 'facultyname',
			mapping : 'faculty.name'
		}, {
			name : 'schoolname',
			mapping : 'faculty.school.name'
		} ]
	}
});