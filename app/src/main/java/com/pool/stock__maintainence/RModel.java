package com.pool.stock__maintainence;

public class RModel {
    String currdate,record_name,record_phone,record_address;
    String record_qty,record_ratepl,record_total,record_GST;
    String status;
    RModel(){

    }

    public RModel(String currdate, String record_name, String record_phone, String record_address, String record_qty, String record_ratepl, String record_total, String record_GST, String status) {
        this.currdate = currdate;
        this.record_name = record_name;
        this.record_phone = record_phone;
        this.record_address = record_address;
        this.record_qty = record_qty;
        this.record_ratepl = record_ratepl;
        this.record_total = record_total;
        this.record_GST = record_GST;
        this.status = status;
    }

    public String getCurrdate() {
        return currdate;
    }

    public void setCurrdate(String currdate) {
        this.currdate = currdate;
    }

    public String getRecord_name() {
        return record_name;
    }

    public void setRecord_name(String record_name) {
        this.record_name = record_name;
    }

    public String getRecord_phone() {
        return record_phone;
    }

    public void setRecord_phone(String record_phone) {
        this.record_phone = record_phone;
    }

    public String getRecord_address() {
        return record_address;
    }

    public void setRecord_address(String record_address) {
        this.record_address = record_address;
    }

    public String getRecord_qty() {
        return record_qty;
    }

    public void setRecord_qty(String record_qty) {
        this.record_qty = record_qty;
    }

    public String getRecord_ratepl() {
        return record_ratepl;
    }

    public void setRecord_ratepl(String record_ratepl) {
        this.record_ratepl = record_ratepl;
    }

    public String getRecord_total() {
        return record_total;
    }

    public void setRecord_total(String record_total) {
        this.record_total = record_total;
    }

    public String getRecord_GST() {
        return record_GST;
    }

    public void setRecord_GST(String record_GST) {
        this.record_GST = record_GST;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
