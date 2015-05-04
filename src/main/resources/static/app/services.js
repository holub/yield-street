var roiApp = angular.module("roiApp.services");
roiApp.factory('Investor', ['$resource', function($resource) {
    return $resource('/investors/:id', {
        id: '@id'
    }, {
        activeYears: {
            url: '/investors/:id/activeYears'
        }
    });
}]);
