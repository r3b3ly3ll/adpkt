package com.opentext.axcelerate.adp.kotlin.task

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/*
"taskConfiguration": {
    "adp_progressTaskTimeout": 0,
    "adp_qpgdb_dbTrustCerts": "",
    "adp_qpgdb_outputJson": "",
    "adp_qpgdb_dbUser": "",
    "adp_qpgdb_jsonFile": null,
    "adp_taskActive": true,
    "adp_executionPersistent": true,
    "adp_qpgdb_dbPassword": "",
    "adp_abortWfOnFailure": true,
    "adp_qpgdb_sqlQuery": "",
    "adp_qpgdb_dbConnectionUrl": "",
    "adp_cleanUpHistory": false,
    "adp_qpgdb_dbConnectionPoolClientKeyPath": "ProcessControl/security/postgres/client.pgbouncer.storage.pkcs.key",
    "adp_loggingEnabled": true,
    "adp_qpgdb_outputFilename": "adp_qpgdb_output_file_name",
    "adp_qpgdb_dbConnectionPoolRootCertPath": "ProcessControl/security/postgres/reco_root.pem.crt",
    "adp_taskTimeout": 0,
    "adp_qpgdb_dbConnectionPoolClientCertPath": "ProcessControl/security/postgres/client.pgbouncer.storage.crt",
    "adp_qpgdb_dbConnectionPoolName": "",
    "adp_qpgdb_jsonResultSizeLimitMB": "2"
}
*/

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class QueryPostgresqlDBConfiguration(
    @JsonProperty("adp_qpgdb_dbUser")
    val adpQpgdbDbUser: String? = null,
    @JsonProperty("adp_qpgdb_dbPassword")
    val adpQpgdbDbPassword: String? = null,
    @JsonProperty("adp_qpgdb_dbConnectionPoolRootCertPath")
    val adpQpgdbDbConnectionPoolRootCertPath: String = "S:/Projects/ProcessControl/security/postgres/root.billing.crt",
    @JsonProperty("adp_qpgdb_dbConnectionPoolClientKeyPath")
    val adpQpgdbDbConnectionPoolClientKeyPath: String = "S:/Projects/ProcessControl/security/postgres/client.billing.key",
    @JsonProperty("adp_qpgdb_dbConnectionPoolClientCertPath")
    val adpQpgdbDbConnectionPoolClientCertPath: String = "S:/Projects/ProcessControl/security/postgres/client.billing.crt",
    @JsonProperty("adp_qpgdb_dbConnectionUrl")
    val adpQpgdbDbConnectionUrl: String,
    @JsonProperty("adp_qpgdb_sqlQuery")
    val adpQpgdbSqlQuery: String,
    @JsonProperty("adp_loggingEnabled")
    val adpLoggingEnabled: Boolean = false
)