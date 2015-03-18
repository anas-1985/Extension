package umjdt.joinpoints;

import context.Context;
import java.util.logging.Logger;

import umjdt.concepts.TID;
import umjdt.concepts.Transaction;
import umjdt.util.BackgroundThread;

public class TransJP extends EventJP
{
	Logger logger = Logger.getLogger(TransJP.class.toString());
	
	private TID tid;
	private int status; 
	private BeginEventJP beginDemarcate;
	private EndEventJP endDemarcate;
	private Transaction transaction; 
	private BackgroundThread thread;
	
	public TransJP()
	{
		super();
		this.thread = new BackgroundThread(Thread.currentThread());
	}
	
	public TransJP(TID _tid)
	{
		super();
		this.tid= _tid;
		this.thread = new BackgroundThread(Thread.currentThread());	
	}
	
	public TransJP(Transaction _transaction)
	{
		this.transaction = _transaction;
		this.tid= _transaction.getTid();
		this.thread = new BackgroundThread(Thread.currentThread());
	}
	
	public TransJP(TransJP _transjp)
	{
		this.transaction= _transjp.getTransaction();
		this.tid= _transjp.getTransaction().getTid();
		this.status = _transjp.getTransaction().getStatus();
		this.thread= _transjp.getThread();
	}
	
	public boolean occurredIn(Context _context, TransJP _tJP)
	{
		boolean result=false;
		if(_context.getTransJp().equals(_tJP))
		{
			result=true;
		}
		return result;
	}
	
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BeginEventJP getBeginDemarcate() {
		return beginDemarcate;
	}

	public void setBeginDemarcate(BeginEventJP beginDemarcate) {
		this.beginDemarcate = beginDemarcate;
	}

	public EndEventJP getEndDemarcate() {
		return endDemarcate;
	}

	public void setEndDemarcate(EndEventJP endDemarcate) {
		this.endDemarcate = endDemarcate;
	}

	public BackgroundThread getThread() {
		return thread;
	}

	public void setThread(BackgroundThread thread) {
		this.thread = thread;
	}

	public TID getTid() {
		return tid;
	}

	public void setTid(TID tid) {
		this.tid = tid;
	}

}
