//返回URL与需要加载的表格json的对应关系
export function getTableMap() {
    var table_map = new Map([
        ["/projectlists", "/project_table/ProjectTable.json"],
        ["/fundlists", "/funds_table/FundsTable.json"],
        ["/authoritylists", "/authority_table/AuthorityTable.json"], 
        ["/papers", "/achievement_table/PaperAchievementTable.json"], 
        ["/works", "/achievement_table/WorkAchievementTable.json"], 
        ["/patents", "/achievement_table/PatentedProduct.json"], 
        ["/scientifics", "/achievement_table/ScientificResearchAchievement.json"], 
        ["/loginlog", "/log_table/LoginLogTable.json"], 
        ["/systemlog", "/log_table/SystemLogTable.json"], 
        ["/operationlog", "/log_table/OperationLogTable.json"], 
        ["/teams", "/team_table/TeamTable.json"], 
        ["/batch", "/check_table/ProjectCheckBranchTable.json"], 
        ["/project", "/check_table/ProjectCheckTable.json"], 
        ["/achievement", "/check_table/AchievementCheckTable.json"], 
        ["/personal", "/check_table/ResearcherCheckTable.json"], 
        ["/college", "/check_table/CollegeCheckTable.json"], 
        ["/roles", "/role_management_table/RoleManagementTable.json"], 
        ["/batch", "/project_review_table/ProjectBranchReview.json"], 
        
    ]);

    return table_map;
}
