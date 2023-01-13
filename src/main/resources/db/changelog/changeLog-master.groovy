package db.changelog

databaseChangeLog {

  changeSet(id: 'Create user account table', author: 'wzorawski') {
    preConditions(onFail: 'MARK_RAN') {
      not() {
        tableExists(tableName: "user_account")
      }
    }
    createTable(tableName: 'user_account') {
      column(name: 'id', type: 'bigint', autoIncrement: true) {
        constraints(nullable: false, primaryKey: true)
      }
      column(name: 'name', type: 'varchar(20)') {}
      column(name: 'last_name', type: 'varchar(30)') {}
      column(name: 'email', type: 'varchar(50)') {}
      column(name: 'user_number', type: 'UUID') {}
    }
    createSequence(sequenceName: 'SEQ_user', startValue: '1')
  }
}