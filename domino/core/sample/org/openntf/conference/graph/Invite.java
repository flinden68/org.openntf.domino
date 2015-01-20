package org.openntf.conference.graph;

import org.openntf.domino.graph2.annotations.AdjacencyUnique;
import org.openntf.domino.graph2.annotations.IncidenceUnique;
import org.openntf.domino.graph2.annotations.TypedProperty;
import org.openntf.domino.graph2.builtin.DEdgeFrame;
import org.openntf.domino.graph2.builtin.DVertexFrame;

import com.tinkerpop.blueprints.Direction;

public interface Invite extends DVertexFrame {
	public static interface Invites extends DEdgeFrame {
		public static final String LABEL = "Invites";

		public Attendee getInviter();

		public Invite getInvite();
	}

	public static interface InvitedTo extends DEdgeFrame {
		public static final String LABEL = "InvitedTo";

		public Attendee getInvitee();

		public Invite getInvite();
	}

	public static interface InvitationFor extends DEdgeFrame {
		public static final String LABEL = "InvitationFor";

		public Event getEvent();

		public Invite getInvite();
	}

	public static enum Status {
		DRAFT, UNREAD, OPEN, TENTATIVE, COMMITTED, DECLINED;
	}

	@TypedProperty("Message")
	public String getMessage();

	@TypedProperty("Message")
	public void setMessage(String message);

	@TypedProperty("Status")
	public Status getStatus();

	@TypedProperty("Status")
	public void setStatus(Status status);

	@AdjacencyUnique(label = Invites.LABEL, direction = Direction.IN)
	public Attendee getInvitingAttendee();

	@AdjacencyUnique(label = Invites.LABEL, direction = Direction.IN)
	public Invites addInvites(Attendee inviter);

	@AdjacencyUnique(label = Invites.LABEL, direction = Direction.IN)
	public void removeInvites(Attendee inviter);

	@IncidenceUnique(label = Invites.LABEL, direction = Direction.IN)
	public Invites getInvites();

	@IncidenceUnique(label = Invites.LABEL, direction = Direction.IN)
	public void removeInvites(Invites invites);

	@AdjacencyUnique(label = InvitedTo.LABEL)
	public Iterable<Attendee> getInvitedToAttendees();

	@AdjacencyUnique(label = InvitedTo.LABEL)
	public Invites addInvitedTo(Attendee invitee);

	@AdjacencyUnique(label = InvitedTo.LABEL)
	public void removeInvitedTo(Attendee invitee);

	@IncidenceUnique(label = InvitedTo.LABEL)
	public Iterable<InvitedTo> getInvitedTos();

	@IncidenceUnique(label = InvitedTo.LABEL)
	public void removeInvitedTo(InvitedTo invitedTo);

	@AdjacencyUnique(label = InvitationFor.LABEL, direction = Direction.IN)
	public Event getEvent();

	@AdjacencyUnique(label = InvitationFor.LABEL, direction = Direction.IN)
	public InvitationFor addEvent(Event event);

	@AdjacencyUnique(label = InvitationFor.LABEL, direction = Direction.IN)
	public void removeEvent(Event event);

	@IncidenceUnique(label = InvitationFor.LABEL, direction = Direction.IN)
	public InvitationFor getInvitationFors();

	@IncidenceUnique(label = InvitationFor.LABEL, direction = Direction.IN)
	public void removeInvitationFor(InvitationFor invitationFor);

}
