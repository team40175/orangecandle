Ext.application({
	name : 'OrangeCandle',
	requires : [ 'OrangeCandle.util.Scalability', 'OrangeCandle.util.Auth',
			'OrangeCandle.form.UserLecture', 'OrangeCandle.form.AssignLecture',
			'OrangeCandle.form.Department', 'OrangeCandle.form.Faculty',
			'OrangeCandle.form.Building' ],
	views : [ 'Login', 'Main', 'ChangePassword', 'AddGroups', 'AddAccount',
			'AddLesson', 'AddSchool', 'AddConstraints', 'AddClassroom' ],
	controllers : [ 'Login', 'Button', 'Submit' ],
	models : [ 'Group', 'Role', 'xUser', 'Lecture', 'Room', 'School',
			'Constraint', 'Buttons', 'Department', 'Faculty', 'Building' ],
	stores : [ 'Group', 'Role', 'xUser', 'Lecture', 'Room', 'School',
			'Constraint', 'UserLecture', 'Buttons', 'Teacher', 'Department',
			'Faculty', 'Building' ],
	// forms : [ 'UserLecture' ],
	icon : {
		'57' : 'resources/icons/Icon.png',
		'72' : 'resources/icons/Icon~ipad.png',
		'114' : 'resources/icons/Icon@2x.png',
		'144' : 'resources/icons/Icon~ipad@2x.png'
	},
	isIconPrecomposed : true,
	startupImage : {
		'320x460' : 'resources/startup/320x460.jpg',
		'640x920' : 'resources/startup/640x920.png',
		'768x1004' : 'resources/startup/768x1004.png',
		'748x1024' : 'resources/startup/748x1024.png',
		'1536x2008' : 'resources/startup/1536x2008.png',
		'1496x2048' : 'resources/startup/1496x2048.png'
	},
	launch : function() {
		Ext.Viewport.add([ {
			xtype : 'loginview',
			fullscreen : true,
			scrollable : false
		} ]);
	}
});
