/**
 * 
 */
package student_classes;

/**
 * Another example of a "minimal interface." Ask why is this interface
 * so sparse? What would be the implications of providing methods 
 * that were more detailed inside
 * of this definition? In particular, consider any method that references or
 * requires a specific kind of Set: this would be problematic. Make sure
 * that you reflect on this assertion and ask why? 
 * Finally, ask why is this an interface as opposed to
 * an (equally vacuous) abstract class?
 * 
 * @author UMD CS Department.
 *
 */
public interface BasicSet<T> {
	public int size();
}
