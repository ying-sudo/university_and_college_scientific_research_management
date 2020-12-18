export function getTableIconMap() {
    var icon_map = new Map([
        ["authoritylists", "AuthorityTableIcon"],

        ["projectlists", "ProjectTableIcon"], 
        ["fundlists","FundsTableIcon"],

        ["teams","TeamTableIcon"],

        ["roles","RoleManageTableIcon"],

        ["papers","PaperTableIcon"],
        ["works","WorkTableIcon"],
        ["patents","PatentTableIcon"],
        ["scientifics","ScientificAchievementTableIcon"],

        ["project_result","ProjectCheckTableIcon"],
        ["paper_result","PaperCheckTableIcon"],
        ["work_result","WorkCheckTableIcon"],
        ["scientific_result","ScientificCheckTableIcon"],
        ["patent_result","PatentCheckTableIcon"],

        ["project_check","ProjectCheckTableIcon"],
        ["paper_check","PaperCheckTableIcon"],
        ["work_check","WorkCheckTableIcon"],
        ["scientific_check","ScientificCheckTableIcon"],
        ["patent_check","PatentCheckTableIcon"],

        ["loginlog", "LoginLogTableIcon"], 
        ["systemlog", "SystemLogTableIcon"], 
        ["operationlog", "OperationLogTableIcon"], 
        
        
    ]);

    return icon_map;
}