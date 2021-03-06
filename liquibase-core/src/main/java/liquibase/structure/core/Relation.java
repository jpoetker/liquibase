package liquibase.structure.core;

import liquibase.structure.AbstractDatabaseObject;
import liquibase.structure.DatabaseObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A container of columns. Usually a table or view.
 */
public abstract class Relation extends AbstractDatabaseObject {

    protected Relation() {
        setAttribute("columns", new ArrayList());
    }

    public String getName() {
        return getAttribute("name", String.class);
    }

    public DatabaseObject[] getContainingObjects() {
        return new DatabaseObject[]{
                getSchema()
        };

    }

    public String getRemarks() {
        return getAttribute("remarks", String.class);
    }

    public Relation setRemarks(String remarks) {
        setAttribute("remarks", remarks);
        return this;
    }

    public List<Column> getColumns() {
        return getAttribute("columns", List.class);
    }

    /**
     * Returns the column object for the given columnName.  If the column does not exist in this table,
     * return null.
     */
    public Column getColumn(String columnName) {
        for (Column column : getColumns()) {
            if (column.getName().equalsIgnoreCase(columnName)) {
                return column;
            }
        }
        return null;
    }

    /**
     * @return Returns the schema.
     */
    public Schema getSchema() {
        return getAttribute("schema", Schema.class);
    }

    /**
     * @param schema The schema to set.
     */
    public Relation setSchema(Schema schema) {
        setAttribute("schema", schema);
        return this;
    }

    public int compareTo(Relation o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }

}
