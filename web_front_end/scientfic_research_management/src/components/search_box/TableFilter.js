export function getfilterMap() {
    var filter_map = new Map([
        ["projectlists", [
            {
                value: "id",
                label: "项目编号",
            }, {
                value: "name",
                label: "项目名称",
            },
        ]], 

        ["fundlists", [
            {
                value: "projectId",
                label: "项目编号",
            }, {
                value: "projectName",
                label: "项目名称",
            },
        ]],

        ["papers", [
            {
                value: "id",
                label: "论文编号",
            }, {
                value: "name",
                label: "论文名称",
            },
        ]],

        ["works", [
            {
                value: "id",
                label: "著作编号",
            }, {
                value: "name",
                label: "著作名称",
            },
        ]],

        ["patents", [
            {
                value: "id",
                label: "专利产品编号",
            }, {
                value: "name",
                label: "专利产品名称",
            },
        ]],

        ["scientifics", [
            {
                value: "id",
                label: "科研成果编号",
            }, {
                value: "name",
                label: "科研成果名称",
            },
        ]],

        ["teams", [
            {
                value: "id",
                label: "团队编号",
            }, {
                value: "name",
                label: "团队名称",
            },
        ]],

        ["project_result", [
            {
                value: "id",
                label: "项目编号",
            }, {
                value: "name",
                label: "项目名称",
            },
        ]],

        ["paper_result", [
            {
                value: "id",
                label: "论文编号",
            }, {
                value: "name",
                label: "论文名称",
            },
        ]],

        ["work_result", [
            {
                value: "id",
                label: "著作号",
            }, {
                value: "name",
                label: "著作名称",
            },
        ]],

        ["scientific_result", [
            {
                value: "id",
                label: "科研成果号",
            }, {
                value: "name",
                label: "科研成果名称",
            },
        ]],

        ["patent_result", [
            {
                value: "id",
                label: "专利号",
            }, {
                value: "name",
                label: "专利名称",
            },
        ]],

        ["personal_result", [
            {
                value: "name",
                label: "姓名",
            },
        ]],

        
    ]);

    return filter_map;
}