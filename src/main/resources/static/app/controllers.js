var roiApp = angular.module("roiApp.controllers", []);
roiApp.controller("AppController", ['$scope', 'Investor', function($scope, Investor) {
    Investor.query(function(response) {
        $scope.investors = response ? response : [];
    });

    $scope.activeYears = function(investor) {
        investor.$activeYears()
    }
}]);
