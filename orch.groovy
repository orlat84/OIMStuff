import groovy.sql.Sql
import oracle.sql.BLOB

def DB_HOST = 'localhost'
def DB_PORT = 1521
def DB_SID = 'orcl112'

def OIM_SCHEMA = "r2ps1_oim"
def OIM_PASSWORD = "Welcome1"

def ORCHID = 222

def printProcessDetails(sql, processNumber) {
    println "\nProcess details for process id $processNumber";
    println '='.padRight(45,'=');
    sql.eachRow("select * from orchprocess where id=$processNumber") {
        def processIDHeader = "Process ID:";
        def statusHeader = "Status:";
        def entityTypeHeader = "Entity type:";
        def entityIDHeader = "Entity ID:";
        def operationHeader = "Operation:";
        def stageHeader = "Stage:";
        def createdOnHeader = "Created on:";
        def modifiedOnHeader = "Modified on:";

        def out = new StringBuffer();
        out << "${processIDHeader.padRight(15, ' ')} ${it.id.toString().padRight(20, ' ')}";
        out << "${statusHeader.padRight(15, ' ')} ${it.status}\n";
        out << "${entityTypeHeader.padRight(15, ' ')} ${it.entitytype.padRight(20, ' ')}";
        out << "${entityIDHeader.padRight(15, ' ')} ${it.entityid}\n";
        out << "${operationHeader.padRight(15, ' ')} ${it.operation.padRight(20, ' ')}";
        out << "${stageHeader.padRight(15, ' ')} ${it.stage}\n\n";
        out << "${createdOnHeader.padRight(15, ' ')} ${it.createdon.timestampValue()}\n";
        out << "${modifiedOnHeader.padRight(15, ' ')} ${it.modifiedon.timestampValue()}\n";
        println out;
    };
}

def printOrchEventDetails(Sql sql, ORCHID) {
    sql.eachRow("SELECT * FROM orchevents where processid=${ORCHID} order by orchorder") {
        blob = (BLOB) it.result

        println "${it.id} ${it.name.padRight(35, ' ')} ${it.status.padRight(15, ' ')} ${it.stage.padRight(25, ' ')} ${it.orchorder}"

        def blobContent = new ObjectInputStream(blob.getBinaryStream()).readObject();
        if (blobContent != null) {
            ((Throwable)blobContent).printStackTrace()
        }
    }
}

sql = Sql.newInstance("jdbc:oracle:thin:@${DB_HOST}:${DB_PORT}:${DB_SID}",
        OIM_SCHEMA, OIM_PASSWORD, "oracle.jdbc.pool.OracleDataSource")

printProcessDetails(sql, ORCHID)
printOrchEventDetails(sql, ORCHID)

sql.connection.close()