//返回URL与需要加载的表格json的对应关系
export function getTableMap() {
    var table_map = new Map([

        ["/projectlists", "/project_table/ProjectTable.json"],
        ["/fundlists", "/funds_table/FundsTable.json"],

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

        ["/result_batch", "/check_result_table/CheckResultBranchTable.json"], 
        ["/project_result", "/check_result_table/ProjectCheckResultTable.json"], 
        ["/paper_result", "/check_result_table/PaperCheckResultTable.json"], 
        ["/work_result", "/check_result_table/WorkCheckResultTable.json"], 
        ["/scientific_result", "/check_result_table/ScientificCheckResultTable.json"], 
        ["/patent_result", "/check_result_table/PatentCheckResultTable.json"], 
        ["/personal_result", "/check_result_table/ResearcherCheckResultTable.json"], 
        ["/college_result", "/check_result_table/CollegeCheckResultTable.json"], 
        ["/team_result", "/check_result_table/TeamCheckResultTable.json"], 

        ["/project_check", "/check_result_table/ProjectCheckResultTable.json"], 
        ["/paper_check", "/check_result_table/PaperCheckResultTable.json"], 
        ["/work_check", "/check_result_table/WorkCheckResultTable.json"], 
        ["/scientific_check", "/check_result_table/ScientificCheckResultTable.json"], 
        ["/patent_check", "/check_result_table/PatentCheckResultTable.json"], 

        ["/reports", "/statistical_statement_table/Statement.json"], 
        
        ["/authoritylists", "/authority_table/AuthorityTable.json"], 
    ]);

    return table_map;
}
