package genderBase;

import java.util.Collection;

import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.impl.common.FastIDSet;

public class GenderItemSimilarity {
	private final FastIDSet men;
	private final FastIDSet women;

	public GenderItemSimilarity(FastIDSet men, FastIDSet women) {
		this.men = men;
		this.women = women;
	}

	public double itemSimilarity(long profileID1, long profileID2) {
		Boolean profile1IsMan = isMan(profileID1);
		if (profile1IsMan == null) {
			return 0.0;
		}
		Boolean profile2IsMan = isMan(profileID2);
		if (profile2IsMan == null) {
			return 0.0;
		}
		return profile1IsMan == profile2IsMan ? 1.0 : -1.0;
	}

	private Boolean isMan(long profileID) {
		if (men.contains(profileID)) {
			return Boolean.TRUE;
		}
		if (women.contains(profileID)) {
			return Boolean.FALSE;
		}
		return null;
	}

	public void refresh(Collection<Refreshable> alreadyRefreshed) {
		// do nothing
	}

}
