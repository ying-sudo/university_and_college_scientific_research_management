export function getTableIconMap() {
    var icon_map = new Map([
        ["authoritylists", "AuthorityTableIcon"], 
        ["projectlists", "ProjectTableIcon"], 
        ["fundlists","FundsTableIcon"],
        ["teams","TeamTableIcon"],
        ["papers","PaperTableIcon"],
        ["works","WorkTableIcon"],
        ["patents","PatentTableIcon"],
        ["roles","RoleManageTableIcon"],
        
        
    ]);

    return icon_map;
}