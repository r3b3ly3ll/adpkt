package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/*
"taskConfiguration": {
    "adp_progressTaskTimeout": 0,
    "adp_createDataSource_abortOnExistingDataSource": false,
    "adp_createDataSource_applicationIdentifier": null,
    "adp_taskActive": true,
    "adp_createDataSource_choosenHostNameParameter": "adp_hostname",
    "adp_executionPersistent": true,
    "adp_createDataSource_choosenHostMemoryRatio": "adp_chosen_host_memory_ratio",
    "adp_abortWfOnFailure": true,
    "adp_createDataSource_chosenHostCpuLoad": "adp_chosen_host_cpu_load",
    "adp_loggingEnabled": true,
    "adp_createDataSource_dataSourceSystemTemplateDisplayName": "Server - file share",
    "adp_createDataSource_usedTemplate": "adp_used_data_source_template",
    "adp_createDataSource_hostCpuLoadThreshold": "50",
    "adp_createDataSource_createdDataSourceNameParameter": "adp_created_data_source_name",
    "adp_createDataSource_retryMaxNumberRunningCrawlers": "30",
    "adp_createDataSource_choosenHostMemory": "adp_chosen_host_memory",
    "adp_createDataSource_workspaceIdentifier": null,
    "adp_createDataSource_hostIdentifier": null,
    "adp_createDataSource_hostMemoryLimit": "0",
    "adp_createDataSource_maxNumberRunningCrawlers": "0",
    "adp_cleanUpHistory": false,
    "adp_createDataSource_engineIdentifier": null,
    "adp_createDataSource_engineBoxDocThreshold": "1000000",
    "adp_createDataSource_hostMemoryLimitRatio": "0",
    "adp_createDataSource_choosenEngineNameParameter": "adp_chosen_engine",
    "adp_createDataSource_hostRolesBlackList": null,
    "adp_createDataSource_dataSourceIdentifier": "{datasource_id}",
    "adp_taskTimeout": 0,
    "adp_createDataSource_createdDataSourceDisplaynameParameter": "adp_created_data_source_displayname",
    "adp_createDataSource_dataSourceTemplate": "",
    "adp_createDataSource_dataSourceName": "{datasource_name}"
}
*/

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CreateDataSourceConfiguration (
    @JsonProperty("adp_createDataSource_dataSourceName")
    val adpCreateDataSourceDataSourceName: String? = null,
    @JsonProperty("adp_createDataSource_applicationIdentifier")
    val adpCreateDataSourceApplicationIdentifier: String? = null,
    @JsonProperty("adp_createDataSource_hostIdentifier")
    val adpCreateDataSourceHostIdentifier: String? = null,
    @JsonProperty("adp_createDataSource_engineIdentifier")
    val adpCreateDataSourceEngineIdentifier: String? = null,
    @JsonProperty("adp_createDataSource_dataSourceTemplate")
    val adpCreateDataSourceDataSourceTemplate: String? = null,
    @JsonProperty("adp_loggingEnabled")
    val adpLoggingEnabled: Boolean = false
)
